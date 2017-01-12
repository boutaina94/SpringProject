/**
 * 
 */

App.factory('StaffService', ['$http', '$q', function($http, $q){
	return {
		logStaff: function(credentials){
			return $http.post('http://127.0.0.1:8080/staff/', credentials).then(
			//return $http.post('http://localhost:8080/staff/', credentials).then(
						function(response){
							console.log('Service  OK, logStaff: ');
							return response.data;
						},
						function(err){
							console.log('Service KOO, logStaff');
							return $q.reject(err);
						}
					);
			}
	}
}]);