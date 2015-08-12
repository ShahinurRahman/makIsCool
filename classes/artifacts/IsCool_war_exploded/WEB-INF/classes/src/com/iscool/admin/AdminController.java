package com.iscool.admin;

import com.iscool.admin.model.*;
import com.iscool.admin.service.AdminService;
import com.iscool.util.ERPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/17/15
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    AdminService adminService;
    //localhost:8080/IsCool/admin//home.cool?id=12

    //REGION
    @RequestMapping(method = RequestMethod.GET, value = "/createRegion.cool")
    public ModelAndView createRegion() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Region");

        List<Region> regionList = adminService.findAllRegion();
        map.put("regionList", regionList);
        return  new ModelAndView("admin/region_create", map);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/saveRegion.cool")
    public ModelAndView saveRegion(@RequestParam("name") String name) {

        Region region = new Region();
        region.setName(name);
        adminService.save(region);


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "Saved successfully");
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Region");

        List<Region> regionList = adminService.findAllRegion();
        map.put("regionList", regionList);

        return  new ModelAndView("admin/region_create", map);
    }


    //COUNTRY
    @RequestMapping(method = RequestMethod.GET, value = "/createCountry.cool")
    public ModelAndView createCountry() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "Saved successfully");
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Country");

        List<Region> regionList = adminService.findAllRegion();
        map.put("regionList", regionList);

        List<Country> countryList = adminService.findAllCountry();
        map.put("countryList", countryList);


        return  new ModelAndView("admin/country_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveCountry.cool")
    public ModelAndView saveCountry(@RequestParam("name") String name,
                                    @RequestParam("regId") Long regId) {

        Region region = adminService.getRegion(regId);
        Country country = new Country();
        country.setName(name);
        country.setRegion(region);

        region.getCountryList().add(country);

        adminService.save(country);



        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "Saved successfully");
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Region");

        List<Region> regionList = adminService.findAllRegion();
        map.put("regionList", regionList);


        return  new ModelAndView("redirect:createCountry.cool", map);
    }

    //CITY
    @RequestMapping(method = RequestMethod.GET, value = "/createCity.cool")
    public ModelAndView createCity() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "City");

        List<Country> countryList = adminService.findAllCountry();
        map.put("countryList", countryList);

        List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);

        return  new ModelAndView("admin/city_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveCity.cool")
    public ModelAndView saveCity(@RequestParam("name") String name,
                                    @RequestParam("countryId") Long countryId) {

        Country country = adminService.getCountry(countryId);

        City city = new City();
        city.setName(name);
        city.setCountry(country);

        country.getCityList().add(city);

        adminService.save(city);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "City");

        List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);
        return  new ModelAndView("redirect:createCity.cool", map);
    }


    //SCHOOL
    @RequestMapping(method = RequestMethod.GET, value = "/createSchool.cool")
    public ModelAndView createSchool() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "School");

        List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);

        return  new ModelAndView("admin/school_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveSchool.cool")
    public ModelAndView saveSchool(@RequestParam("name") String name,
                                 @RequestParam("cityId") Long cityId,
                                 @RequestParam("address1") String address1,
                                 @RequestParam("address2") String address2,
                                 @RequestParam("description") String description){

        City city = adminService.getCity(cityId);

        School school = new School();

        school.setName(name);
        school.setAddress1(address1);
        school.setAddress2(address2);
        school.setDescription(description);
        school.setCity(city);

        city.getCityList().add(school);

        adminService.save(school);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "School");

        /*List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);*/

        return  new ModelAndView("redirect:createSchool.cool", map);
    }


    //DEPARTMENT
    @RequestMapping(method = RequestMethod.GET, value = "/createDepartment.cool")
    public ModelAndView createDepartment() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Department");

        List<School> schoolList = adminService.findAllSchool();
        map.put("schoolList", schoolList);

        return  new ModelAndView("admin/department_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveDepartment.cool")
    public ModelAndView saveDepartment(@RequestParam("name") String name,
                                       @RequestParam("schoolId") Long schoolId,
                                       @RequestParam("description") String description){

        School school = adminService.getSchool(schoolId);

        Department department = new Department();

        department.setName(name);
        department.setDescription(description);
        department.setSchool(school);

        school.getDepartmentList().add(department);

        adminService.save(department);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Department");

        /*School<School> schoolList = adminService.findAllSchool();
        map.put("schoolList", schoolList);*/

        return  new ModelAndView("redirect:createDepartment.cool", map);
    }


    //TEACHER
    @RequestMapping(method = RequestMethod.GET, value = "/createTeacher.cool")
    public ModelAndView createTeacher() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Teacher");

        /*List<Country> countryList = adminService.findAllCountry();
        map.put("countryList", countryList);*/

       /* List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);*/

        return  new ModelAndView("admin/teacher_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveTeacher.cool")
    public ModelAndView saveTeacher(@RequestParam("name") String name,
                                    @RequestParam("designation") String designation,
                                    @RequestParam("department") String department,
                                    @RequestParam("address") String address,
                                    @RequestParam("contact") String contact,
                                    @RequestParam("email") String email) {

        //Country country = adminService.getCountry(countryId);

        Teacher teacher = new Teacher();

        teacher.setName(name);
        teacher.setDesignation(designation);
        teacher.setDepartment(department);
        teacher.setAddress(address);
        teacher.setContact(contact);
        teacher.setEmail(email);

        adminService.save(teacher);

        //country.getCityList().add(city);

        //adminService.save(city);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Teacher");

        /*List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);*/

        return  new ModelAndView("redirect:createTeacher.cool", map);
    }



    //GUARDIAN
    @RequestMapping(method = RequestMethod.GET, value = "/createGuardian.cool")
    public ModelAndView createGuardian() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Guardian");

        /*List<Country> countryList = adminService.findAllCountry();
        map.put("countryList", countryList);*/

       /* List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);*/

        return  new ModelAndView("admin/guardian_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveGuardian.cool")
    public ModelAndView saveGuardian(@RequestParam("name") String name,
                                    @RequestParam("address") String address,
                                    @RequestParam("designation") String designation,
                                    @RequestParam("description") String description,
                                    @RequestParam("contact") String contact,
                                    @RequestParam("email") String email) {

        //Country country = adminService.getCountry(countryId);

        Guardian guardian = new Guardian();

        guardian.setName(name);
        guardian.setAddress(address);
        guardian.setDesignation(designation);
        guardian.setDescription(description);
        guardian.setContact(contact);
        guardian.setEmail(email);

        adminService.save(guardian);

        //country.getCityList().add(city);

        //adminService.save(city);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Guardian");

        /*List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);*/

        return  new ModelAndView("redirect:createGuardian.cool", map);
    }



    //STUDENT
    @RequestMapping(method = RequestMethod.GET, value = "/createStudent.cool")
    public ModelAndView createStudent() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Student");

        /*List<Country> countryList = adminService.findAllCountry();
        map.put("countryList", countryList);*/

       /* List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);*/

        return  new ModelAndView("admin/student_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveStudent.cool")
    public ModelAndView saveStudent(@RequestParam("name") String name,
                                     @RequestParam("roll") String roll,
                                     @RequestParam("batch") String batch,
                                     @RequestParam("shift") String shift,
                                     @RequestParam("department") String department,
                                     @RequestParam("session") String session,
                                     @RequestParam("guardian") String guardian,
                                     @RequestParam("age") String age,
                                     @RequestParam("sex") String sex,
                                     @RequestParam("address") String address,
                                     @RequestParam("contact") String contact,
                                     @RequestParam("email") String email,
                                     @RequestParam("reference") String reference) {

        //Country country = adminService.getCountry(countryId);

        Student student = new Student();

        student.setName(name);
        student.setRoll(roll);
        student.setBatch(batch);
        student.setShift(shift);
        student.setDepartment(department);
        student.setSession(session);
        student.setGuardian(guardian);
        student.setAge(age);
        student.setSex(sex);
        student.setAddress(address);
        student.setContact(contact);
        student.setEmail(email);
        student.setReference(reference);

        adminService.save(student);

        //country.getCityList().add(city);

        //adminService.save(city);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Student");

        /*List<City> cityList = adminService.findAllCity();
        map.put("cityList", cityList);*/

        return  new ModelAndView("redirect:createStudent.cool", map);
    }




    //STAFF
    @RequestMapping(method = RequestMethod.GET, value = "/createStaff.cool")
    public ModelAndView createStaff() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Staff");

        return  new ModelAndView("admin/staff_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveStaff.cool")
    public ModelAndView saveStaff(@RequestParam("name") String name,
                                     @RequestParam("designation") String designation,
                                     @RequestParam("department") String department,
                                     @RequestParam("address") String address,
                                     @RequestParam("contact") String contact,
                                     @RequestParam("email") String email) {

        Staff staff = new Staff();

        staff.setName(name);
        staff.setDesignation(designation);
        staff.setDepartment(department);
        staff.setAddress(address);
        staff.setContact(contact);
        staff.setEmail(email);

        adminService.save(staff);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("DashBoardLink", ERPConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Staff");

        return  new ModelAndView("redirect:createStaff.cool", map);
    }



     //Test_page
    @RequestMapping(method = RequestMethod.GET, value = "/createTest.cool")
    public ModelAndView createTest() {

        return  new ModelAndView("admin/create_test");
    }


}





