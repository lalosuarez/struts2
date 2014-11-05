var app = angular.module('app',[]);

app.controller('TeamCtrl', function($scope, $http, $filter) {
  
  $scope.loadLeagues = function() {
	console.log("Loading...");
	var uri = "../../rest/json/leagues";
    $.ajax({
        url: uri,
        type: 'GET',
        dataType: 'json',
        success: function(data) {

          var json = [];

          /*
           * Genera el json con el formato de jquery para el autocomplete.
           */
/*          $.each(data["leagues"], function(key, value) {
            json.push({"label":value['name'], "id":value['id']});
          });*/
          
          $.each(data, function(key, value) {
              json.push({"label":value['name'], "id":value['id']});
              //console.log(value['name']);
          });          
          
          var input = document.getElementById("leagueInput");   

          $(input).autocomplete({
              source: json,
              minLength: 2,
              select: function(event, ui) {
                  seleccionado = ui.item.id;
                  $('#leagueId').val(seleccionado);
              }                          
          });

        }
    });    
  }
  
  $scope.loadLeagues();

  /*$scope.leagues = null;

  $scope.load = function() {

      $http.get('../leagues/getAllJson',{

      }).success(function(data) {

        $scope.leagues = data;

      }).error(function(e){});      
  }

  $scope.load();*/

});

/*app.config(function($interpolateProvider){
  $interpolateProvider.startSymbol('[[').endSymbol(']]');
});*/