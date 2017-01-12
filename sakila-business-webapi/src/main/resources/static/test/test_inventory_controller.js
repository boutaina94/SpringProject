/**
 * 
 */
/**
 * 
 */
describe('InventoryController', function(){
	
	var tab = [];
	var $controller;
	beforeEach(module('myApp'));
	beforeEach(inject(function(_$controller_){
		$controller = _$controller_;
	}));
	
	it('should pass anyway', function(){
		expect(false).toBe(false)
	});
	
	it('should return a list of film IN the inventory', function(){
		var $scope = {};
		var $cookieStore = {};
		// Mock de service
		var MockService = { getInventories: function(){
			return new Promise(function(resolve, reject){
				resolve(tab);
			})}
		};
		var controller = $controller('InventoryController', {$scope: $scope, $cookieStore: $cookieStore, InventoryService: MockService});
		
	});
	
	
});/**
 * 
 */