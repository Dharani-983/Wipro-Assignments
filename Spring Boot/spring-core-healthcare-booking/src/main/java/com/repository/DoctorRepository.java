package com.repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DoctorRepository {
	private Map<String, List<String>> doctorSchedule;

    public void setDoctorSchedule(Map<String, List<String>> doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }

    public boolean isDoctorAvailable(String doctorId, LocalDate date) {
        List<String> availableDates = doctorSchedule.get(doctorId);
        if (availableDates == null) return false;

        for (String dateStr : availableDates) {
            if (LocalDate.parse(dateStr).equals(date)) {
                return true;
            }
        }
        return false;
    }
}
