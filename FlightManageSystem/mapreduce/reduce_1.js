function(key, values) {
	var result = {count: 0, delay: 0};
	for(var i = 0; i < values.length; i++) {
    	result.delay += values[i].delay;
    	result.count += values[i].count;    
	}
	return result;
};