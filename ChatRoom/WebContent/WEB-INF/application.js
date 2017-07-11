/**
 * 
 */


var app=angular.module('MyApplication',['ngRoute','regmodule','JobModule','loginapp','BlogModule','StudentJobModule','ngCookies']);

app.constant('REST_URI','http://localhost:9109/MyChatApp/');

app.controller('HomeController',function($scope,$rootScope,$cookies,$location){
	/*$rootScope.Userrole="home";*/
	$rootScope.Userrole=$cookies.get('role');
	console.log($cookies.get('role'));
	var name='secondproject';
	$scope.name=name;
	console.log(name);
	
	this.logout=function()
	{
		alert("logout");
		$rootScope.Userrole="";
		$cookies.remove('role');
		$location.path("/")
	}
})


app.config(function($routeProvider)
{
	
	$routeProvider
	.when("/home",{
		templateUrl:'index.html',
		controller :'HomeController',
		controllerAs:'home'
	})
	.when("/signup",
			{
		templateUrl:'./userdata/SignUp.html',
		controller:'RegisterController',
		controllerAs:'refCtrl'
		})
		.when("/jobposting",
				{
			templateUrl:'./AdminData/JobPosting.html',
			controller:'JobController',
			controllerAs:'jobCtrl'
			})
			
			.when("/jobs",
					{
						templateUrl:'./userdata/job.html',
						controller:'StudentJobController',
						controllerAs:'stdJobCtrl'
					})
					
			.when("/allblog",
					{
				templateurl:'./AdminData/blog.html',
				controller:'BlogController',
				controllerAs:'blogCtrl'
					})
			.when("/applyjob",
					{
				templateUrl:'./userdata/applyjob.html',
				controller:'StudentController',
				controllerAs:'stdJobCtrl'
					})
	}
	)