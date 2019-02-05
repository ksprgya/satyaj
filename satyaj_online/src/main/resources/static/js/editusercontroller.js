/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('edituserCtrl', function($scope,$http,$location){
	
	$scope.url="url is - "+$location.param+"  ";
	// there is how to get there id
    $http.get("../rest/user/3").then(function (response){

        $scope.name=response.data.name;
        $scope.mobile=response.data.mobile;
        $scope.email=response.data.email;
        $scope.city=response.data.city;

    });
	

});