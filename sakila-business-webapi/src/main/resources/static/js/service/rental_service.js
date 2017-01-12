/**
 * 
 */
App.factory('RentalService', ['$http', '$q', function($http, $q){
	return {
		getRental: function(){
			console.log('Using the Rental Service: getRental.');
//			return $http.post('http://localhost:8080/getRentals/').then(
			return $http.post('http://127.0.0.1:8080/getRentals/').then(
					function(res){
						console.log('Service OK, getRental: ');
						return res.data
					},
					function(err){
						console.log('Service NOK, getRental: ...');
						return $q.reject(err);
					}
			);
		},
		createRental: function(rent){
			console.log('Using the Rental Service: createRental.');
//			return $http.post('http://localhost:8080/createRental/', rent).then(
			return $http.post('http://127.0.0.1:8080/createRental/', rent).then(
					
					function(res){
						console.log('Service OK, createRentall: ');
						return res.data
					},
					function(err){
						console.log('Service KO, createRental: ...');
						return $q.reject(err);
					}
			);
		},
		deleteRental: function(rental){
			console.log('Using the Rental Service: deleteRental.');
//			return $http.get('http://localhost:8080/deleteRental/' + rental['rentalId']).then(
			return $http.get('http://127.0.0.1:8080/deleteRental/' + rental['rentalId']).then(
					function(res){
						console.log('Service OK, deleteRental: ');
						return res.data;
					},
					function(err){
						console.log('Service KO, deleteRental ...');
						return $q.reject(err);
					}
			);
		},
		updateRental: function(rental){
			console.log('Using the Rental Service: updateRental.');
//			return $http.post('http://localhost:8080/updateRental/', rental).then(
			return $http.post('http://127.0.0.1:8080/updateRental/', rental).then(
					
					function(res){
						console.log('Service Ok, updateRental');
						return res.data;
					},
					function(err){
						console.log('Service KO, updateRental');
						return $q.reject(err);
					}
			);	
		}
	}
}]);