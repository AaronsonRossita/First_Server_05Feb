package com.example.first_server_05feb.service;

import com.example.first_server_05feb.model.PaymentMethod;
import com.example.first_server_05feb.model.Student;
import com.example.first_server_05feb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    public void createStudent(Student student) throws Exception{
        if (student.getPaymentMethod() == PaymentMethod.VOUCHER){
            if (repository.getStudentsByPaymentMethod(PaymentMethod.VOUCHER).size() < 5){
                repository.createStudent(student);
            }else{
                throw new Exception("can't pay with voucher");
            }
        }else{
            repository.createStudent(student);
        }
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        if (student.getPaymentMethod() != PaymentMethod.VOUCHER){
            repository.updateStudent(student);
        }else{
            if (repository.getStudentById(student.getId()).getPaymentMethod() == PaymentMethod.VOUCHER){
                repository.updateStudent(student);
            }else if(repository.getStudentsByPaymentMethod(PaymentMethod.VOUCHER).size() < 5){
                repository.updateStudent(student);
            }else{
                throw new Exception("can't pay with voucher");
            }
        }
    }

    @Override
    public List<String> getStudentEmailByName(String name) {
        return repository.getStudentEmailByName(name);
    }

    @Override
    public List<Integer> getAllId() {
        return repository.getAllId();
    }
}
