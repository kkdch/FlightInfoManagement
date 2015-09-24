/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wayne.cs.fms.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;
import edu.wayne.cs.fms.entity.FlightInfo;
import edu.wayne.cs.fms.entity.SearchInfo;
import java.util.ArrayList;
import org.bson.types.ObjectId;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author daichenhan
 */
public class CRUD {

    public static void Insert(FlightInfo info, MongoClient mongoClient) {
        //MongoClient mongoClient = Connector.connect("localhost", 27017);
        DB db = mongoClient.getDB("project");
        DBCollection flight = db.getCollection("flight");
        BasicDBObject query = new BasicDBObject("FL_DATE", info.getDate()).append("UNIQUE_CARRIER", info.getCarrier());
        query.append("FL_NUM", info.getTailNum()).append("ORIGIN_CITY_NAME", info.getDepCity());
        query.append("DEST_CITY_NAME", info.getArrCity()).append("CRS_DEP_TIME", info.getCrsDepTime());
        query.append("CRS_ARR_TIME", info.getCrsArrTime()).append("DISTANCE", info.getDistance());
        query.append("CANCELLED", info.getCancel());
        if (info.getCancel() == 0) {
            query.append("DEP_TIME", info.getDepTime()).append("DEP_DELAY", info.getDepDelay());
            query.append("ARR_TIME", info.getArrTime()).append("ARR_DELAY", info.getArrDelay());
        }
        System.out.println(query);
        flight.insert(query);
        //mongoClient.close();

    }

    public static void Update(String id, FlightInfo newInfo, MongoClient mongoClient) {
        //MongoClient mongoClient = Connector.connect("localhost", 27017);
        DB db = mongoClient.getDB("project");
        DBCollection flight = db.getCollection("flight");
        ObjectId oId = new ObjectId(id);
        BasicDBObject query0 = new BasicDBObject("_id", oId);
        BasicDBObject query = new BasicDBObject("FL_DATE", newInfo.getDate()).append("UNIQUE_CARRIER", newInfo.getCarrier());
        query.append("FL_NUM", newInfo.getTailNum()).append("ORIGIN_CITY_NAME", newInfo.getDepCity());
        query.append("DEST_CITY_NAME", newInfo.getArrCity()).append("CRS_DEP_TIME", newInfo.getCrsDepTime());
        query.append("CRS_ARR_TIME", newInfo.getCrsArrTime()).append("DISTANCE", newInfo.getDistance());
        query.append("CANCELLED", newInfo.getCancel());
        if (newInfo.getCancel() == 0) {
            query.append("DEP_TIME", newInfo.getDepTime()).append("DEP_DELAY", newInfo.getDepDelay());
            query.append("ARR_TIME", newInfo.getArrTime()).append("ARR_DELAY", newInfo.getArrDelay());
        }
        System.out.println(query0);
        System.out.println(query);
        flight.update(query0, query);
        //mongoClient.close();
    }

    public static void Delete(String id, MongoClient mongoClient) {
        ObjectId oId = new ObjectId(id);
        BasicDBObject query = new BasicDBObject("_id", oId);
        //MongoClient mongoClient = Connector.connect("localhost", 27017);
        DB db = mongoClient.getDB("project");
        DBCollection flight = db.getCollection("flight");
        System.out.println(query);
        flight.remove(query);
        //mongoClient.close();
    }

    public static DBCursor Search(SearchInfo sInfo, String colName, MongoClient mongoClient) {

        BasicDBObject query = new BasicDBObject();

        //Time Range
        if (sInfo.getUpDate() != null && sInfo.getDownDate() != null) {
            String upDateStr = sInfo.getUpDate().toString();
            String downDateStr = sInfo.getDownDate().toString();
            DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd");
            LocalDate upDate = df.parseLocalDate(upDateStr);
            LocalDate downDate = df.parseLocalDate(downDateStr);
            ArrayList dates = new ArrayList();
            for (LocalDate date = downDate; date.isBefore(upDate.plusDays(1)); date = date.plusDays(1)) {
                dates.add(date.toString());
            }
            query.append("FL_DATE", new BasicDBObject("$in", dates));
        }
        //Carrier
        if (sInfo.getCarrier() != null) {
            query.append("UNIQUE_CARRIER", sInfo.getCarrier());
        }
        //TailNum
        if (sInfo.getTailNum() != 0) {
            query.append("FL_NUM", sInfo.getTailNum());
        }
        //DepCity
        if (sInfo.getDepCity() != null) {
            query.append("ORIGIN_CITY_NAME", sInfo.getDepCity());
        }
        //ArrCity
        if (sInfo.getArrCity() != null) {
            query.append("DEST_CITY_NAME", sInfo.getArrCity());
        }
        //DistanceRange
        query.append("DISTANCE", new BasicDBObject("$gt", sInfo.getDownDis()).append("$lt", sInfo.getUpDis()));
        //DepTimeRange
        query.append("CRS_DEP_TIME", new BasicDBObject("$gt", sInfo.getDownDepTime()).append("$lt", sInfo.getUpDepTime()));
        //ArrTimeRange
        query.append("CRS_ARR_TIME", new BasicDBObject("$gt", sInfo.getDownArrTime()).append("$lt", sInfo.getUpArrTime()));
        //Cancel
        if (sInfo.getCancel() != -1) {
            query.append("CANCELLED", sInfo.getCancel());
        }

        System.out.println(query);
        //MongoClient mongoClient = Connector.connect("localhost", 27017);
        DB db = mongoClient.getDB("project");
        DBCollection flight = db.getCollection(colName);
        DBCursor cursor = flight.find(query);
        return cursor;
    }

    public static ArrayList MapReduce(String colName, String map, String reduce, String finalize, MongoClient mongoClient) {
        //MongoClient mongoClient = Connector.connect("localhost", 27017);
        DB db = mongoClient.getDB("project");
        DBCollection temp = db.getCollection(colName);

        ArrayList result = new ArrayList();
        MapReduceCommand cmd = new MapReduceCommand(temp, map, reduce,
                null, MapReduceCommand.OutputType.INLINE, null);

        if (finalize != null) {
            cmd.setFinalize(finalize);
        }

        MapReduceOutput out = temp.mapReduce(cmd);

        for (DBObject o : out.results()) {
            result.add(o.toString());
        }
        System.out.println("Done");
        //mongoClient.close();
        return result;
    }

    public static void Save(DBObject doc, String tempColName, MongoClient mongoClient) {
        //MongoClient mongoClient = Connector.connect("localhost", 27017);
        DB db = mongoClient.getDB("project");
        DBCollection temp = db.getCollection(tempColName);
        temp.save(doc);
        //mongoClient.close();
    }

    public static void CreateCol(String tempColName, MongoClient mongoClient) {
        //MongoClient mongoClient = Connector.connect("localhost", 27017);
        DB db = mongoClient.getDB("project");
        DBObject options = BasicDBObjectBuilder.start().add("capped", true).add("size", 2000000000l).get();
        db.createCollection(tempColName, options);
        //mongoClient.close();
    }

    public static void DropCol(String colName, MongoClient mongoClient) {
        //MongoClient mongoClient = Connector.connect("localhost", 27017);
        DB db = mongoClient.getDB("project");
        DBCollection myCollection = db.getCollection(colName);
        myCollection.drop();
        //mongoClient.close();
    }

}
