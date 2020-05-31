package hr.tvz.pilipovic.studapp.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail jobStudentsPrintDetail() {
        return
                JobBuilder.newJob(JobStudentsPrint.class).withIdentity("jobStudentPrint").storeDurably().build();
    }
    @Bean
    public Trigger objavaJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();
        return TriggerBuilder.newTrigger().forJob(jobStudentsPrintDetail())
                .withIdentity("jobStudentPrint").withSchedule(scheduleBuilder).build();
    }
}