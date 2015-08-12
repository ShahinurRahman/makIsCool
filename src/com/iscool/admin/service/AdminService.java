package com.iscool.admin.service;

import com.iscool.admin.model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 2/26/15
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */

public interface AdminService {

    //Region
    public boolean save(Region region);

    public boolean update(Region region);

    public boolean delete(Region region);

    public List<Region> findAllRegion();

    public Region getRegion(Long id);


    //Country
    public boolean save(Country country);

    public boolean update(Country country);

    public boolean delete(Country country);

    public Country getCountry(Long countryId);

    public Country getCountry(String query);

    public List<Country> findAllCountry();

    public List<Country> findAllCountry(String query);


    //City
    public boolean save(City city);

    public boolean update(City city);

    public boolean delete(City city);

    public City getCity(Long cityId);

    public City getCity(String query);

    public List<City> findAllCity();

    public List<City> findAllCity(String query);


    //School
    public boolean save(School school);

    public boolean update(School school);

    public boolean delete(School school);

    public School getSchool(Long schoolId);

    public School getSchool(String query);

    public List<School> findAllSchool();

    public List<School> findAllSchool(String query);


    //Department
    public boolean save(Department department);

    public boolean update(Department department);

    public boolean delete(Department department);

    public Department getDepartment(Long departmentId);

    public Department getDepartment(String query);

    public List<Department> findAllDepartment();

    public List<Department> findAllDepartment(String query);


    //Teacher
    public boolean save(Teacher teacher);

    public boolean update(Teacher teacher);

    public boolean delete(Teacher teacher);

    public Teacher getTeacher(Long teacherId);

    public Teacher getTeacher(String query);

    public List<Teacher> findAllTeacher();

    public List<Teacher> findAllTeacher(String query);


    //Guardian
    public boolean save(Guardian guardian);

    public boolean update(Guardian guardian);

    public boolean delete(Guardian guardian);

    public Guardian getGuardian(Long guardianId);

    public Guardian getGuardian(String query);

    public List<Guardian> findAllGuardian();

    public List<Guardian> findAllGuardian(String query);


    //Student
    public boolean save(Student student);

    public boolean update(Student student);

    public boolean delete(Student student);

    public Student getStudent(Long studentId);

    public Student getStudent(String query);

    public List<Student> findAllStudent();

    public List<Student> findAllStudent(String query);



    //Staff
    public boolean save(Staff staff);

    public boolean update(Staff staff);

    public boolean delete(Staff staff);

    public Staff getStaff(Long staffId);

    public Staff getStaff(String query);

    public List<Staff> findAllStaff();

    public List<Staff> findAllStaff(String query);

}
