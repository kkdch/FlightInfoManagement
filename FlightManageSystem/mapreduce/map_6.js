function() {
    emit({carrier: this.UNIQUE_CARRIER, flight: this.FL_NUM}, {count: 1, delay: this.ARR_DELAY});
};
