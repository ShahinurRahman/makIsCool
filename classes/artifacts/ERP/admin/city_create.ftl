<#import "../my_template/my_app_layout.ftl" as layout>
<@layout.my_app_layout "${PageTitle}" >
<!--Row for Bread Crumb-->
<div class="row">
    <div class="col-lg-12">
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i> <a href="${DashBoardLink}">Dashboard</a>
            </li>
            <li>
                <i class="fa fa-list"></i><a href="IsCool/admin/createCity.cool"> ${PageTitle} List</a>
            </li>
            <li>
                <i class="fa fa-cog fa-spin"></i> Creating ${PageTitle}
            </li>

        </ol>
    </div>
</div>

<div class="row">
    <div class="col-lg-12 text-center">
        <div class="panel panel-default">
            <div class="panel-body">
                <h3 class="text-left text-success">Create ${PageTitle}</h3>

                <div class="col-lg-6 text-center">
                    <form name="dataForm" id="dataForm" action="saveCity.cool" method="POST">
                        <div class="col-lg-4 text-left">
                            City Name
                        </div>
                        <div class="col-lg-8 text-center">

                            <div class="form-group has-success">
                                <input type="text" name="name" id="name" class="form-control">
                            </div>
                        </div>
                        <div class="col-lg-4 text-left">
                            Country
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <select name="countryId" id="regId" class="form-control">
                                    <#list countryList as country>
                                        <option value="${country.id}">${country.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                        </div>
                        <div class="col-lg-8 text-right">
                            <button type="reset" class="btn btn-primary">Reset</button>
                            <button type="submit" class="btn btn-success">Save</button>
                        </div>
                    </form>
                </div>


                <div class="col-lg-3 text-center">
                   <#-- <#if msg??>${msg}</#if>-->
                </div>
                <div class="col-lg-3 text-center table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>City Name</th>
                            <th>Country</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#if cityList??>
                                <#list cityList as city>
                                <tr>
                                    <td>${city.id}</td>
                                    <td>${city.name}</td>
                                    <td>${city.country.name}</td>
                                </tr>
                                </#list>
                            </#if>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!--End First Row -->




</@layout.my_app_layout>


