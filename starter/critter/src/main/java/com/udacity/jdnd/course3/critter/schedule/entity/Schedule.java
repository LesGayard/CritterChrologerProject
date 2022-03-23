package com.udacity.jdnd.course3.critter.schedule.entity;


import javax.persistence.*;
import java.util.*;


/* Schedules that indicate one or more employees will be meeting one or more pets to perform one or more activities on a specific day */
@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="schedule_id")
    private Long scheduleId;


    @Column(name="appointment")
    private Date appointment;

    public Schedule() {
    }

    public Schedule(Long scheduleId, Date appointment) {
        this.scheduleId = scheduleId;
        this.appointment = appointment;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }
}
