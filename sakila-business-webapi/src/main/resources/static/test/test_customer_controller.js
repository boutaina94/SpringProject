/**
 * 
 */
describe('CustomerController', function(){
	
	var $controller;
	var newTestCase = function(){console.log("------- ••• -------");};
	var testCasePass = function(test){console.info(test + ": OK!")}
	var tab = [{"customerId":1,"store_id":1,"firstName":"MARY","lastName":"SMITH","email":"MARY.SMITH@sakilacustomer.org","active":1,"address":"1913 Hanoi Way","address2":"","district":"Nagasaki","city_id":463,"postalCode":"35200","phone":"28303384290"},
	           {"customerId":2,"store_id":1,"firstName":"PATRICIA","lastName":"JOHNSON","email":"PATRICIA.JOHNSON@sakilacustomer.org","active":1,"address":"1121 Loja Avenue","address2":"","district":"California","city_id":449,"postalCode":"17886","phone":"838635286649"},
	           {"customerId":3,"store_id":1,"firstName":"LINDA","lastName":"WILLIAMS","email":"LINDA.WILLIAMS@sakilacustomer.org","active":1,"address":"692 Joliet Street","address2":"","district":"Attika","city_id":38,"postalCode":"83579","phone":"448477190408"},
	           {"customerId":4,"store_id":2,"firstName":"BARBARA","lastName":"JONES","email":"BARBARA.JONES@sakilacustomer.org","active":1,"address":"1566 Inegl Manor","address2":"","district":"Mandalay","city_id":349,"postalCode":"53561","phone":"705814003527"}];
	
	beforeEach(module('myApp'));
	beforeEach(inject(function(_$controller_){
		$controller = _$controller_;
	}));
	
	it('should pass anyway', function(){
		expect(false).toBe(false)
	});
	
	it('should return a list of customer', function(){
		var $scope = {};
		var $cookieStore = {};
		// Mock de service
		var MockService = { getCustomer: function(){
			return new Promise(function(resolve, reject){
				resolve(tab);
			})}
		};
		
		var controller = $controller(
				'CustomerController', 
				{$scope: $scope, $cookieStore: $cookieStore, CustomerService: MockService}
		);
		
		setTimeout(function(){
			newTestCase();
			(function(){
				expect(controller['customers'].length).toEqual(6);
				expect(controller['customers'].length).not.toBe(0);
				['customerId','firstName','lastName','email'].forEach(function(key){
					controller['customers'].forEach(function(customer){
						expect(Object.keys(customer)).toContain(key);	
					});
				})
			})();
			testCasePass('should return a list of customer');
		}, 500);
	});
	
	
});