'use strict';

App.factory('CityService', ['$http', '$q', function($http, $q){
	return {
		fetchAllCities: function() {
//			return $http.get('http://localhost:8080/getCities/')
			return $http.get('http://127.0.0.1:8080/getCities/')
			.then(
					function(response){
						console.log('Service City OK: city');
						return response.data;
					}, 
					function(errResponse){
						console.log('Service city KO: load cities');
						return $q.reject(errResponse);
					}
			);
		},
		addCity: function(city){
//			return $http.post('http://localhost:8080/createCity/', city)
			return $http.post('http://127.0.0.1:8080/createCity/', city)
			.then(
					function(response){
						console.log('Service City OK: addCity');
						return response.data;
					}, 
					function(errResponse){
						console.log(' city KO : addCity');
						return $q.reject(errResponse);
					}
			);
		},
		updateCity: function(city){
//			return $http.post('http://localhost:8080/updateCity/', city)
			return $http.post('http://127.0.0.1:8080/updateCity/', city)///a voir
			.then(
					function(response){
						console.log('ana f UpdateService');
						console.log('service City OK: updateCity');
						return response.data;
					}, 
					function(errResponse){
						console.log('ana f  KO UpdateService');
						console.log('Service city KO:  updateCity');
						return $q.reject(errResponse);
					}
			);
		},
		deleteCity: function(cityId){
//			return $http.get('http://localhost:8080/deleteCountry/' +countryId).then(
			return $http.get('http://127.0.0.1:8080/deleteCity/' +cityId).then(
					function(res){
						console.log('service City OK : deleteCity');
						return res.data;
					},
					function(err){
						console.log(' Service city KO: deleteCity');
						$q.reject(err);
					}
					
			);		
		}
	}
}]);