/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('homeCtroller', function($scope,$http,$location,$window){
    	
    	$scope.editUser = function()
    	{
    		alert("hi");
    	}
    	
    	$scope.allUsers = function() {
            $http({
                method: 'GET',
                url: '/rest/users/'
            }).then(function(res){
            	$scope.user=res.data;
            });
            
//            $window.location.href="/users";
        };
});