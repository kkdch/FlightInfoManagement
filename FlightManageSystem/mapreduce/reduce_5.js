function(key, values) {
	var result = {count: 0, dtime: 0, coun: 0};
	for(var i = 0; i < values.length; i++) {
    	if (values[i].dtime < 1200){
    		result.coun += values[i].coun;
    	}
    	result.count += values[i].count;
    }
	return result;
};
