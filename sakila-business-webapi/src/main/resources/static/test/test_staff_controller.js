/**
 * 
 */

describe('StaffController', function(){
	var $controller;
	beforeEach(module('myApp'));
	beforeEach(inject(function(_$controller_){
		$controller = _$controller_;
	}));
	
	it('shoul pass any way', function(){
		expect(true).toBe(true);
	});
	
	it('should declare as authenticate', function(){
		var $scope = {};
		var $cookieStore = {};
		// Mock de service
		var MockStaffService = { logStaff : function(){
			return new Promise(function(resolve, reject) {
					resolve({'username': 'a-non-null-username'});
				});
			}
		};
		
		var controller = $controller('StaffController', {$scope: $scope, $cookieStore: $cookieStore, StaffService: MockStaffService});
		controller['staff'] = {'username': 'Jon', 'password': 'jon1'};
		// finally the TEST ! ! !
		controller.submit(function(res){expect(res).toBe(true);});
	});
	
	
	it('should declare as non-authenticate', function(){
		var $scope = {};
		//Mock de service
		var MockStaffService = { logStaff : function(){
			return new Promise(function(resolve, reject) {
					resolve({'username': null});
				});
			}
		};
		
		var controller = $controller('StaffController', {$scope: $scope, StaffService: MockStaffService});
		controller['staff'] = {'username': 'Jon', 'password': 'jon1'};
		controller.submit(function(res){expect(res).toBe(false);});
	});
	
});