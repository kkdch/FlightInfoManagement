function(key, values) {
	var t = {count: 0};
	for(var i = 0; i < values.length; i++) {
    	t.count += values[i].count;
	}
	return t;
};