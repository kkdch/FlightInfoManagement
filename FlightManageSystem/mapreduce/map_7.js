function() {
    emit({carrier: this.UNIQUE_CARRIER, name: this.ORIGIN_CITY_NAME}, {count: 1});
};
