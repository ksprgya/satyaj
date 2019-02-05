/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('userCtrl', function($scope,$http,$location,$window){
        $http.get("rest/users").then(function (response){
            $scope.userList = response.data; 

        });
        
    	$scope.editUser = function(uid)
    	{
          $window.location.href='/edituser/'+uid;
    	}

});