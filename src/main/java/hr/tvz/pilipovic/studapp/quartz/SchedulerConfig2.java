package hr.tvz.pilipovic.studapp.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;

import static org.quartz.CronScheduleBuilder.cronSchedule;

@Configuration
public class SchedulerConfig2 {

    @Bean
    public JobDetail jobStudentsPrintDetail2() {
        return
                JobBuilder.newJob(JobStudentsPrint.class).withIdentity("jobStudentPrint2").storeDurably().build();
    }
    @Bean
    public Trigger objavaJobTrigger2() {

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                /*.weeklyOnDayAndHourAndMinute(DateBuilder.MONDAY, 12, 00)
                .weeklyOnDayAndHourAndMinute(DateBuilder.FRIDAY, 12, 00)*/
                .atHourAndMinuteOnGivenDaysOfWeek(12, 00, DateBuilder.MONDAY, DateBuilder.FRIDAY)
                .inTimeZone(TimeZone.getTimeZone("Europe/Zagreb"));


        return TriggerBuilder.newTrigger().forJob(jobStudentsPrintDetail2())
                .withIdentity("jobStudentPrint2")
                .withSchedule(cronScheduleBuilder)
                //.withSchedule(cronSchedule("0 0 12pm * ? * THU,FRI"))
                .build();
              //  .forJob("jobStudentPrint2", "group1")

    }
}