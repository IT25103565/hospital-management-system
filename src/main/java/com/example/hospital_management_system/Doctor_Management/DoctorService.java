package com.example.hospital_management_system.Doctor_Management;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private final String FILE_PATH = "doctors.txt";

    // READ
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    doctors.add(new Doctor(data[0], data[1], data[2], Integer.parseInt(data[3])));
                }
            }
        } catch (IOException e) {
            // File will be created on first write
        }
        return doctors;
    }

    private void saveAllDoctors(List<Doctor> doctors) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Doctor d : doctors) {
                bw.write(d.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public void addDoctor(Doctor doctor) {
        List<Doctor> doctors = getAllDoctors();
        doctors.add(doctor);
        saveAllDoctors(doctors);
    }

    // READ by ID
    public Doctor getDoctorById(String id) {
        return getAllDoctors().stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    // UPDATE
    public void updateDoctor(Doctor updatedDoctor) {
        List<Doctor> doctors = getAllDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId().equals(updatedDoctor.getId())) {
                doctors.set(i, updatedDoctor);
                break;
            }
        }
        saveAllDoctors(doctors);
    }

    // DELETE
    public void deleteDoctor(String id) {
        List<Doctor> doctors = getAllDoctors();
        doctors.removeIf(d -> d.getId().equals(id));
        saveAllDoctors(doctors);
    }
}