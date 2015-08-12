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
                <i class="fa fa-list"></i><a href="IsCool/admin/createStudent.cool"> ${PageTitle} List</a>
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
                    <form name="dataForm" id="dataForm" action="saveStudent.cool" method="POST">
                        <div class="col-lg-4 text-left">
                            Student Name
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <input type="text" name="name" id="name" class="form-control">
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                            Roll
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <input type="text" name="roll" id="roll" class="form-control">
                            </div>
                        </div>


                        <div class="col-lg-4 text-left">
                            Batch
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <select name="batch" id="batch" class="form-control">
                                    <option value="batch">A</option>
                                    <option value="batch">B</option>
                                    <option value="batch">C</option>
                                    <option value="batch">D</option>
                                </select>

                            </div>
                        </div>


                        <div class="col-lg-4 text-left">
                            Shift
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <select name="shift" id="shift" class="form-control">
                                    <option value="shift">Morning</option>
                                    <option value="shift">Day</option>
                                </select>
                            </div>
                        </div>


                        <div class="col-lg-4 text-left">
                            Department
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <select name="department" id="department" class="form-control">
                                    <option value="department">Science</option>
                                    <option value="department">Commerce</option>
                                    <option value="department">Humanities</option>
                                </select>
                            </div>
                        </div>


                        <div class="col-lg-4 text-left">
                            Session
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <select name="session" id="session" class="form-control">
                                    <option value="session">2010-11</option>
                                    <option value="session">2011-12</option>
                                    <option value="session">2012-13</option>
                                    <option value="session">2013-14</option>
                                    <option value="session">2014-15</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                            Guardian Name
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <input type="text" name="guardian" id="guardian" class="form-control">
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                            Age
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <input type="text" name="age" id="age" class="form-control">
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                            Sex
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <select name="sex" id="sex" class="form-control">
                                    <option value="sex">Male</option>
                                    <option value="sex">Female</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                            Address
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <input type="text" name="address" id="address" class="form-control">
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                            Contact
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <input type="text" name="contact" id="contact" class="form-control">
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                            Email
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <input type="text" name="email" id="email" class="form-control">
                            </div>
                        </div>

                        <div class="col-lg-4 text-left">
                            Reference
                        </div>
                        <div class="col-lg-8 text-center">
                            <div class="form-group has-success">
                                <input type="text" name="reference" id="reference" class="form-control">
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

            </div>
        </div>
    </div>

</div>

<!--End First Row -->




</@layout.my_app_layout>


