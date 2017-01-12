/**
 */
describe('CityController', function(){
	
	var $controller;
	var cityTable = [{"cityId":1,"city":"al-Qatif","country":null},
	                 {"cityId":2,"city":"Celaya","country":null},
	                 {"cityId":3,"city":" Ambattur","country":null}];
	
	beforeEach(module('myApp'));
	beforeEach(inject(function(_$controller_){
		$controller = _$controller_;
	}));
	
	it('should pass anyway', function(){
		expect(false).toBe(false)
	});
	
	it('should return a list of city', function(){
		var $scope = {};
		var $cookieStore = {};
		// Mock de service
		var MockService = { fetchAllCities: function(){
			return new Promise(function(resolve, reject){
				resolve(cityTable)
			});
		}};
		
		var controller =  null;
		var allTest = function(){
			expect(controller['cities'].length).toEqual(3);
		}
		
		async.series([function(){
			controller = $controller('CityController', {$scope: $scope, $cookieStore:$cookieStore, CustomerService: MockService});
		},allTest
		])
	});
	
	
});/*
 * 
 */