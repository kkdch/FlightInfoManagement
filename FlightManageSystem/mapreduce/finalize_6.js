function(key, result){
    result.avg = result.delay / result.count;
    return result;
}