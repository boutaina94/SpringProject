'use strict';

App.controller('CityController', [
		'$scope',
		'CityService',
		function($scope, CityService) {
			var self = this;
			self.city = {
				cityId : ' ',
				city : '',
				countryId : ''
			};
			self.cities = [];

			self.fetchAllCities = function() {
				CityService.fetchAllCities().then(function(d) {
					self.cities = d;
				}, function(errResponse) {
					console.error('Error while fetching Currencies');
				});
			};

			self.createCity = function(city) {
				console.log(city)
				CityService.addCity(city).then(self.fetchAllCities,
						function(errResponse) {
							console.error('Error while creating City.');
						});
			};

			self.updateCity = function(city) {
				CityService.updateCity(city).then(self.fetchAllCities,
						function(errResponse) {
							console.error('Error while updating City.');
						});
			};
			self.remove = function(id){
	        	  CityService.deleteCityy(id).then(
	        			  self.fetchAllCities,
	        			  function(){}
	        	  )
	          };
			

			self.submit = function() {
				if (self.city.cityId == ' ') {
					console.log('Saving New City', self.city.city);
					console.log('Saving New City', self.city.countryId);
					console.log('Saving New City', self.city);
					
					console.log('ana f Create');
					self.createCity(self.city);
				} else {
					console.log('City updating with id ', self.city.cityId);
					console.log('City: ', self.city);
					
					console.log('ana f Update');
					self.updateCity(self.city).then(self.fetchAllCities(),
							function() {
							})
				}
				self.reset();
				
			};
			self.fetchAllCities();

			// self.edit = function(cityId) {
			// console.log('id to be edited : ', cityId);
			// console.log('length cities : '+self.cities.length);
			// for (var i = 0; i < self.cities.length; i++) {
			// console.log(self.cities[i].cityId);
			// if (self.cities[i].cityId == cityId) {
			// self.city = angular.copy(self.cities[i]);
			// console.log(self.cities[i].cityId);
			// break;
			// }
			// }
			// };

			self.edit = function(city) {
				self.city = angular.copy(city);
				// self.fetchAllCities();

			};

			self.reset = function() {
				self.city = {
					cityId : ' ',
					city : '',
					countryId : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			};

		} ]);