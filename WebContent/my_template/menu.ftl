<!--Slider-->

<div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav side-nav" style="height: 100%">
        <li>
            <a href="../home.cool"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#access_dd"><i class="fa fa-fw fa-edit"></i> Access <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="access_dd" class="collapse">
                <li><a href="/IsCool/security/createUser.cool?errMsg=" class="null">User</a></li>
                <li><a href="/IsCool/security/authorityList.cool" class="null">Authority</a></li>
                <li><a href="/IsCool/security/featureList.cool" class="null">Feature</a></li>
                <li><a href="/IsCool/security/userGroupList.cool" class="null">User Group</a></li>
                <li><a href="/IsCool/security/componentList.cool" class="null">Component</a></li>

            </ul>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#hrm_dd"><i class="fa fa-fw fa-desktop"></i>ADMIN<i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="hrm_dd" class="collapse">
                <li><a href="/IsCool/admin/createRegion.cool">Region-Area</a></li>
                <li><a href="/IsCool/admin/createCountry.cool">Country</a></li>
                <li><a href="/IsCool/admin/createCity.cool">City</a></li>
                <li><a href="/IsCool/admin/createSchool.cool">School</a></li>
                <li><a href="/IsCool/admin/createDepartment.cool">Department</a></li>
                <li><a href="/IsCool/admin/createTeacher.cool">Teacher</a></li>
                <li><a href="/IsCool/admin/createGuardian.cool">Guardian</a></li>
                <li><a href="/IsCool/admin/createStudent.cool">Student</a></li>
                <li><a href="/IsCool/admin/createStaff.cool">Staff</a></li>
                <li><a href="/IsCool/admin/createTest.cool">Test_Page</a></li>

            <#--<li><a href="/IsCool/hrm/#.cool">User Type</a></li>-->
            </ul>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#brtc_dd"><i class="fa fa-fw fa-wrench"></i> B R T C <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="brtc_dd" class="collapse">
                <li><a href="/IsCool/brtc/clientList.cool"><b>Client</b></a></li>
                <li><a href="/IsCool/brtc/brtcProjectList.cool?findFor=all"><b>Project</b></a></li>
             <#--   <li><a href="/IsCool/brtc/moneyReceiptList.cool">Team</a></li>
                <li><a href="/IsCool/brtc/projectHistoryList.cool?fileNo=33"><b>History</b></a></li>-->
            </ul>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#finance_dd"><i class="fa fa-fw fa-dollar"></i> Finance <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="finance_dd" class="collapse">
                <li><a href="/IsCool/brtc/clientPaymentList.cool?findFor=all&status=0"><b>Client Payment</b></a></li>
                <li><a href="/IsCool/brtc/paymentRequestList.cool?status=0"><b>Advance Req.</b></a></li>
                <#--<li><a href="/IsCool/brtc/#"><b>Adv. Adjustment</b></a></li>--><#--
                <li><a href="/IsCool/brtc/createDistribution.cool?fileNo=33"><b>Distribution</b></a></li>-->
            </ul>
        </li>
        <li>
            <a href="/IsCool/report/reportHome.cool"><i class="fa fa-fw fa-list"></i> Reports</a>
        </li>



        <li>
            <div class="col-lg-12 text-center">
               <form name="searchForm" role="form" id="searchForm" action="/IsCool/brtc/brtcProjectList.cool" method="GET">
                    <div class="form-group input-group">
                        <input type="text" name="findFor" class="form-control"
                               placeholder="Project">
                        <span class="input-group-addon"><a class="fa fa-search"  onclick="$(this).submit()"></a></span>
                    </div>
                </form>
            </div>
        </li>
        <li>
            <div class="col-lg-12 text-center">
                <form name="searchForm" role="form" id="searchForm" action="/IsCool/brtc/viewBrtcProject.cool" method="GET">
                    <div class="form-group input-group">
                        <input type="text" name="fileNo" id="fileNoForProjectSearch" class="form-control" placeholder="File No.">
                        <span class="input-group-addon"><a class="fa fa-search" href="#" onclick="$(this).submit()"></a></span>
                    </div>
                </form>
            </div>
        </li>
        <li>
        </li>
    </ul>
</div>

<script>
    /*
    var myVar=setInterval(function(){myTimer()},1000);

    function myTimer() {
        var d = new Date();
        document.getElementById("clock").innerHTML = d.toLocaleTimeString();
    }   */
</script>
<!--/Slider-->