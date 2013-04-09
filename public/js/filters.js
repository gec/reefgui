'use strict';

/* Filters */

var SERVICES_STATUS_PROGRESS = {
    INITIALIZING: "20",
    AMQP_UP: "40",
    UP: "100",
    AMQP_DOWN: "20",
    CONFIGURATION_FILE_FAILURE: "20",
    AUTHENTICATION_FAILURE: "60",
    APPLICATION_SERVER_DOWN: "10",
    APPLICATION_REQUEST_FAILURE: "10"
};

angular.module('charlotte.filters', []).
    filter('csv', function() {
          return function(strArray) {
                if (strArray ) {
                    return strArray.join(", ");
                } else {
                    return "";
                }
          };
        }).
    filter('serviceStatusLoading', function() {
          return function(status) {
              if( status.reinitializing)
                return "loading..."
              else if( status.servicesStatus === "UP")
                return "Loading succeeded."
              else
                return "Loading failed."
          };
        }).
    filter('serviceStatusProgressClass', function() {
          return function(status) {
              if( status.reinitializing)
                return "progress progress-striped active"
              else if( status.servicesStatus === "UP")
                return "progress"
              else
                return "progress"
          };
        }).
    filter('serviceStatusProgressPercent', function() {
          return function(status) {
            return SERVICES_STATUS_PROGRESS[ status];
          };
        });
