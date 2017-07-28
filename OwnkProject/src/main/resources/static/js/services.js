var app = angular.module("ownk", ["ngResource"]);

app.controller('OwnkController', ['$scope', '$http',
    function ($scope, $http) {
        
        $scope.getVendedores = function () {
            $http({
                method: 'GET',
                url: '/api/vendedor/'
            }).then(function (success) {
                $scope.texto = success.status;
                $scope.vendedores = success.data;
            }, function (error) {
                $scope.texto = error.status;
            });
        }
        
        $scope.getProductos = function () {
            $http({
                method: 'GET',
                url: '/api/producto/'
            }).then(function (success) {
                $scope.texto = success.status;
                $scope.productos = success.data;
            }, function (error) {
                $scope.texto = error.status;
            });
        }
        
        $scope.init = function () {
            $scope.getProductos();
            $scope.getVendedores();
        }

        $scope.addVendedor = function () {
            $http.post('/api/vendedor/add',
                    {
                        nombres: $scope.nombres,
                        apellidos: $scope.apellidos,
                        cedula: $scope.cedula
                    }
            ).then(function (success) {   
                $scope.nombres=null;
                $scope.apellidos=null;
                $scope.cedula=null;
                $scope.vendedores = success.data;
                $scope.texto = success.status;
            }, function (error) {
                $scope.texto = error.status;
            });
        }
        
        $scope.addProducto = function () {
            $http.post('/api/producto/add',
                    {
                        codigo: $scope.codigo,
                        descripcion: $scope.descripcion,
                        idVend: $scope.idVend
                    }
            ).then(function (success) {
                $scope.codigo=null;
                $scope.descripcion=null;
                $scope.idVend=null;
                $scope.productos = success.data;                
                $scope.texto = success.status;
            }, function (error) {
                $scope.texto = error.status;
            });
        }
        
        $scope.delVendedor = function () {
            $http.post('/api/vendedor/del',
                    {
                        nombres: $scope.nombres,
                        apellidos: $scope.apellidos,
                        cedula: $scope.cedula
                    }
            ).then(function (success) {   
                $scope.nombres=null;
                $scope.apellidos=null;
                $scope.cedula=null;
                $scope.vendedores = success.data;
                $scope.texto = success.status;
            }, function (error) {
                $scope.texto = error.status;
            });
        }
        
    }]);