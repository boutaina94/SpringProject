'use strict';

App.factory('LanguageService', ['$http', '$q', function($http, $q){

	return {

		fetchAllLanguages: function() {
//			return $http.get('http://localhost:8080/getLanguages/')
			return $http.get('http://127.0.0.1:8080/getLanguages/')
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error(' fetching language KO');
						return $q.reject(errResponse);
					}
			);
		},

		createLanguage: function(language){
//			return $http.post('http://localhost:8080/createLanguage/', language)
			return $http.post('http://127.0.0.1:8080/createLanguage/', language)
			
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error(' creating language ko');
						return $q.reject(errResponse);
					}
			);
		},

		updateLanguage: function(language, languageId){
//			return $http.post('http://localhost:8080/updateLanguage/', language)
			return $http.post('http://127.0.0.1:8080/updateLanguage/', language)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('updating language KO');
						return $q.reject(errResponse);
					}
			);
		},

		deleteLanguage: function(languageId){
//			return $http.get('http://localhost:8080/deleteLanguage/'+languageId)
			return $http.get('http://127.0.0.1:8080/deleteLanguage/'+languageId)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('deleting language KO');
						return $q.reject(errResponse);
					}
			);
		}

	};

}]);

