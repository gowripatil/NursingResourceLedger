'use strict'

var nursingResourceLedgerApp = angular.module('nursingResourceLedger', ['ui.bootstrap', 'nursingResourceLedger.controllers',
    'nursingResourceLedger.services'
]);
nursingResourceLedgerApp.constant("CONSTANTS", {
    getUserByIdUrl: "/user/getUser/",
    getAllUsers: "/user/getAllUsers",
    saveUser: "/user/saveUser"
});