/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wayne.cs.fms.controller;

import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daichenhan
 */
public class Connector {
    public static MongoClient connect(String url,int port){
        MongoClient mongoClient=null;
        try {
            mongoClient=new MongoClient(url, port);
        } catch (Exception e) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, e);
        }
        return mongoClient;
    }
}
