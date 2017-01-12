'use strict';

var App = angular.module('myApp',['ngCookies', 'checklist-model']);//

App.controller('AuthController', ['$scope', '$cookieStore', '$location', function($scope, $cookieStore, $location) {
	var self = this;
	self.id = function(){
		var staff_id_cookie = $cookieStore.get('staff_id');
		if($location.absUrl().search(/login.html/) != -1){
			if(typeof staff_id_cookie !== 'undefined'){
				window.location.href="/Home.html";
			}
		} else {
			if(typeof staff_id_cookie === 'undefined'){
				window.location.href="/login.html";
			}
		}
	}

}]);
