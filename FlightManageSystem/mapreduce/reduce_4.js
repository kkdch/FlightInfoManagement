function(key, values) {
	var result = {count: 0, dis: 0, coun: 0};
	for(var i = 0; i < values.length; i++) {
    	if (values[i].dis > 1500){
    		result.coun += values[i].coun;
    	}
    	result.count += values[i].count;
    	result.dis += values[i].dis;
	}
	return result;
};