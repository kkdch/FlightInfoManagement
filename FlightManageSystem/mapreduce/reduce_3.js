function(key, values) {
	var result = {count: 0,cancel: 0};
	for(var i = 0; i < values.length; i++) {
    	result.cancel += values[i].cancel;
    	result.count += values[i].count;    
	}
	return result;
};