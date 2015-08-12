package com.iscool.admin.service;

import com.iscool.admin.dao.*;
import com.iscool.admin.model.*;
import com.iscool.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/26/15
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class AdminServiceImpl implements AdminService {

    //Region Implementation
    @Autowired
    RegionDAO regionDAO;

    @Override
    public boolean save(Region region) {
        return regionDAO.save(region);
    }

    @Override
    public boolean update(Region region) {

        /*User g = new Guardian();
        g.setActive(true);*/
        return regionDAO.update(region);

    }

    @Override
    public boolean delete(Region region) {
        return regionDAO.delete(region);
    }

    @Override
    public List<Region> findAllRegion() {
        return regionDAO.findAllRegions();
    }

    @Override
    public Region getRegion(Long id) {
        return regionDAO.getRegion(id);
    }


    //Country Implementation
    @Autowired
    private CountryDAO countryDAO;

    @Override
    public boolean save(Country country) {
        return countryDAO.save(country);
    }

    @Override
    public boolean update(Country country) {
        return countryDAO.update(country);
    }

    @Override
    public boolean delete(Country country) {
        return countryDAO.delete(country);
    }

    @Override
    public Country getCountry(Long id) {
        return countryDAO.getCountry(id);
    }

    @Override
    public Country getCountry(String query) {
        return countryDAO.getCountry(query);
    }

    @Override
    public List<Country> findAllCountry() {
        return countryDAO.findAllCountry();
    }


    @Override
    public List<Country> findAllCountry(String query) {
        return countryDAO.findAllCountry(query);
    }


    //City Implementation
    @Override
    public boolean save(City city) {
        return cityDAO.save(city);
    }

    @Autowired
    private CityDAO cityDAO;

    @Override
    public boolean update(City city) {
        return cityDAO.update(city);
    }

    @Override
    public boolean delete(City city) {
        return cityDAO.delete(city);
    }

    @Override
    public City getCity(Long id) {
        return cityDAO.getCity(id);
    }

    @Override
    public City getCity(String query) {
        return cityDAO.getCity(query);
    }


    @Override
    public List<City> findAllCity() {
        return cityDAO.findAllCity();
    }


    @Override
    public List<City> findAllCity(String query) {
        return cityDAO.findAllCity(query);
    }


    //School Implementation
    @Autowired
    private SchoolDAO schoolDAO;

    @Override
    public boolean save(School school) {
        return schoolDAO.save(school);
    }

    @Override
    public boolean update(School school) {
        return schoolDAO.update(school);
    }

    @Override
    public boolean delete(School school) {
        return schoolDAO.delete(school);
    }

    @Override
    public School getSchool(Long id) {
        return schoolDAO.getSchool(id);
    }

    @Override
    public School getSchool(String query) {
        return schoolDAO.getSchool(query);
    }

    @Override
    public List<School> findAllSchool() {
        return schoolDAO.findAllSchool();
    }

    @Override
    public List<School> findAllSchool(String query) {
        return schoolDAO.findAllSchool(query);
    }


    //Department Implementation
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public boolean save(Department department) {
        return departmentDAO.save(department);
    }

    @Override
    public boolean update(Department department) {
        return departmentDAO.update(department);
    }

    @Override
    public boolean delete(Department department) {
        return departmentDAO.delete(department);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentDAO.getDepartment(id);
    }

    @Override
    public Department getDepartment(String query) {
        return departmentDAO.getDepartment(query);
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentDAO.findAllDepartment();
    }

    @Override
    public List<Department> findAllDepartment(String query) {
        return departmentDAO.findAllDepartment(query);
    }


    //Teacher Implementation
    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    public boolean save(Teacher teacher) {
        return teacherDAO.save(teacher);
    }

    @Override
    public boolean update(Teacher teacher) {
        return teacherDAO.update(teacher);
    }

    @Override
    public boolean delete(Teacher teacher) {
        return teacherDAO.delete(teacher);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherDAO.getTeacher(id);
    }

    @Override
    public Teacher getTeacher(String query) {
        return teacherDAO.getTeacher(query);
    }


    @Override
    public List<Teacher> findAllTeacher() {
        return teacherDAO.findAllTeacher();
    }


    @Override
    public List<Teacher> findAllTeacher(String query) {
        return teacherDAO.findAllTeacher(query);
    }


    //Guardian Implementation
    @Autowired
    private GuardianDAO guardianDAO;

    @Override
    public boolean save(Guardian guardian) {
        return guardianDAO.save(guardian);
    }

    @Override
    public boolean update(Guardian guardian) {
        return guardianDAO.update(guardian);
    }

    @Override
    public boolean delete(Guardian guardian) {
        return guardianDAO.delete(guardian);
    }

    @Override
    public Guardian getGuardian(Long id) {
        return guardianDAO.getGuardian(id);
    }

    @Override
    public Guardian getGuardian(String query) {
        return guardianDAO.getGuardian(query);
    }


    @Override
    public List<Guardian> findAllGuardian() {
        return guardianDAO.findAllGuardian();
    }


    @Override
    public List<Guardian> findAllGuardian(String query) {
        return guardianDAO.findAllGuardian(query);
    }


    //Student Implementation
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public boolean save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public boolean delete(Student student) {
        return studentDAO.delete(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDAO.getStudent(id);
    }

    @Override
    public Student getStudent(String query) {
        return studentDAO.getStudent(query);
    }


    @Override
    public List<Student> findAllStudent() {
        return studentDAO.findAllStudent();
    }


    @Override
    public List<Student> findAllStudent(String query) {
        return studentDAO.findAllStudent(query);
    }



    //Staff Implementation
    @Autowired
    private StaffDAO staffDAO;

    @Override
    public boolean save(Staff staff) {
        return staffDAO.save(staff);
    }

    @Override
    public boolean update(Staff staff) {
        return staffDAO.update(staff);
    }

    @Override
    public boolean delete(Staff staff) {
        return staffDAO.delete(staff);
    }

    @Override
    public Staff getStaff(Long id) {
        return staffDAO.getStaff(id);
    }

    @Override
    public Staff getStaff(String query) {
        return staffDAO.getStaff(query);
    }


    @Override
    public List<Staff> findAllStaff() {
        return staffDAO.findAllStaff();
    }


    @Override
    public List<Staff> findAllStaff(String query) {
        return staffDAO.findAllStaff(query);
    }

}
