package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private Set<Log> logs;
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public LogParser(Path logDir) {
        this.logDir = logDir;
        downloadLogs();
    }

    private Stream<Log> logsBetweenDates(Date after, Date before) {
        return logs.stream()
                .filter(log -> (after == null || log.date.after(after))
                        && (before == null || log.date.before(before)));
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> result = new HashSet<>();
        Stream<Log> filteredLogs = logs.stream();
        if (query.contains("and date between")) {
            String dates = query.split(" and date between ")[1];
            try {
                String[] s = dates.split("\"");
                Date after = DATE_FORMAT.parse(dates.split("\"")[1]);
                Date before = DATE_FORMAT.parse(dates.split("\"")[3]);
                filteredLogs = logsBetweenDates(after, before);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String[] queryArr = query.split(" ");
        if (queryArr.length > 5) {
            String fieldValue = query.split(" = ")[1].replaceAll("\"", "")
                    .split(" and date between ")[0];
            switch (queryArr[3]) {
                case "ip":
                    filteredLogs = filteredLogs
                            .filter(log -> log.ip.equals(fieldValue));
                    break;
                case "user":
                    filteredLogs = filteredLogs
                            .filter(log -> log.userName.equals(fieldValue));
                    break;
                case "date":
                    try {
                        Date fromQuery = DATE_FORMAT.parse(fieldValue);
                        filteredLogs = filteredLogs
                                .filter(log -> log.date.equals(fromQuery));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "event":
                    filteredLogs = filteredLogs
                            .filter(log -> log.event.toString().equals(fieldValue));
                    break;
                case "status":
                    filteredLogs = filteredLogs
                            .filter(log -> log.status.toString().equals(fieldValue));
            }
        }
        String startQuery = queryArr[0] + " " + queryArr[1];
        switch (startQuery) {
            case "get ip":
                filteredLogs.map(log -> log.ip).forEach(result::add);
                break;
            case "get user":
                filteredLogs.map(log -> log.userName).forEach(result::add);
                break;
            case "get date":
                filteredLogs.map(log -> log.date).forEach(result::add);
                break;
            case "get event":
                filteredLogs.map(log -> log.event).forEach(result::add);
                break;
            case "get status":
                filteredLogs.map(log -> log.status).forEach(result::add);
        }
        return result;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return logsBetweenDates(after, before)
                .map(log -> log.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.userName.equals(user))
                .map(log -> log.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.event == event)
                .map(log -> log.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.status == status)
                .map(log -> log.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllUsers() {
        return logs.stream().map(log -> log.userName).collect(Collectors.toSet());
    }

    /**
     * должен возвращать количество уникальных пользователей
     */
    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return (int) logsBetweenDates(after, before).map(log -> log.userName)
                .distinct().count();
    }

    /**
     * должен возвращать количество событий от определенного пользователя
     */
    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return (int) logsBetweenDates(after, before).filter(log -> log.userName.equals(user))
                .map(log -> log.event).distinct().count();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return logsBetweenDates(after, before).filter(log -> log.ip.equals(ip))
                .map(log -> log.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return logsBetweenDates(after, before).filter(log -> log.event == Event.LOGIN)
                .map(log -> log.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return logsBetweenDates(after, before).filter(log -> log.event == Event.DOWNLOAD_PLUGIN)
                .map(log -> log.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return logsBetweenDates(after, before).filter(log -> log.event == Event.WRITE_MESSAGE)
                .map(log -> log.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return logsBetweenDates(after, before).filter(log -> log.event == Event.SOLVE_TASK)
                .map(log -> log.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return logsBetweenDates(after, before)
                .filter(log -> log.event == Event.SOLVE_TASK && log.taskNumber == task)
                .map(log -> log.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return logsBetweenDates(after, before).filter(log -> log.event == Event.DONE_TASK)
                .map(log -> log.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return logsBetweenDates(after, before)
                .filter(log -> log.event == Event.DONE_TASK && log.taskNumber == task)
                .map(log -> log.userName).collect(Collectors.toSet());
    }

    /**
     * должен возвращать множество дат, когда переданный пользователь произвел переданное событие за выбранный период.
     */
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.userName.equals(user) && log.event == event)
                .map(log -> log.date).collect(Collectors.toSet());
    }

    /**
     * множество дат, когда любое событие не выполнилось за выбранный период.
     */
    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.status == Status.FAILED)
                .map(log -> log.date).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.status == Status.ERROR)
                .map(log -> log.date).collect(Collectors.toSet());
    }

    /**
     * должен возвращать дату, когда переданный пользователь впервые залогинился за
     * выбранный период. Если такой даты в логах нет - null.
     */
    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.userName.equals(user) && log.event == Event.LOGIN)
                .map(log -> log.date).sorted().findFirst().orElse(null);
    }

    /**
     * должен возвращать дату, когда переданный пользователь впервые попытался решить задачу
     * с номером task за выбранный период. Если такой даты в логах нет - null
     */
    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.userName.equals(user) && log.event == Event.SOLVE_TASK
                    && log.taskNumber == task)
                .map(log -> log.date).sorted().findFirst().orElse(null);
    }

    /**
     * должен возвращать дату, когда переданный пользователь впервые решил задачу с номером
     * task за выбранный период. Если такой даты в логах нет - null.
     */
    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.userName.equals(user) && log.event == Event.DONE_TASK
                        && log.taskNumber == task)
                .map(log -> log.date).sorted().findFirst().orElse(null);
    }

    /**
     * должен возвращать множество дат, когда переданный пользователь написал сообщение за выбранный период.
     */
    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDatesForUserAndEvent(user, Event.WRITE_MESSAGE, after, before);
    }

    /**
     * должен возвращать множество дат, когда переданный пользователь скачал плагин за выбранный период.
     */
    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDatesForUserAndEvent(user, Event.DOWNLOAD_PLUGIN, after, before);
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return logsBetweenDates(after, before)
                .map(log -> log.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.ip.equals(ip))
                .map(log -> log.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.userName.equals(user))
                .map(log -> log.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.status == Status.FAILED)
                .map(log -> log.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.status == Status.ERROR)
                .map(log -> log.event).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return (int) logsBetweenDates(after, before)
                .filter(log -> log.event == Event.SOLVE_TASK && log.taskNumber == task)
                .count();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return (int) logsBetweenDates(after, before)
                .filter(log -> log.event == Event.DONE_TASK && log.taskNumber == task)
                .count();
    }

    /**
     * должен возвращать мапу (номер_задачи : количество_попыток_решить_ее) за выбранный период
     */
    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.event == Event.SOLVE_TASK)
                .collect(Collectors.toMap(log -> log.taskNumber, log -> 1, Integer::sum));
    }

    /**
     * должен возвращать мапу (номер_задачи : сколько_раз_ее_решили)
     */
    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return logsBetweenDates(after, before)
                .filter(log -> log.event == Event.DONE_TASK)
                .collect(Collectors.toMap(log -> log.taskNumber, log -> 1, Integer::sum));
    }

    private void downloadLogs() {
        Set<Log> result = new HashSet<>();
        Set<String> logStrings = new HashSet<>();
        try {
            List<Path> logFiles = Files.walk(logDir).filter(path -> path.toString().endsWith(".log"))
                    .collect(Collectors.toList());
            for (Path logFile : logFiles) {
                Files.lines(logFile).forEach(logStrings::add);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String logString : logStrings) {
            String[] arr = logString.split("\t");
            int nextPosition = 0;
            String ip = arr[nextPosition++];
            String userName = arr[nextPosition++];
            Date date;
            try {
                date = DATE_FORMAT.parse(arr[nextPosition++]);
            } catch (ParseException e) {
                e.printStackTrace();
                continue;
            }
            String[] eventArr = arr[nextPosition++].split(" ");
            Event event = Event.valueOf(eventArr[0]);
            int taskNumber = 0;
            if (eventArr.length == 2) {
                taskNumber = Integer.parseInt(eventArr[1]);
            }
            Status status = Status.valueOf(arr[nextPosition]);
            Log log = new Log(ip, userName, date, event, taskNumber, status);
            result.add(log);
        }
        logs = result;
    }

    private class Log {
        String ip;
        String userName;
        Date date;
        Event event;
        int taskNumber;
        Status status;

        public Log(String ip, String userName, Date date, Event event,int taskNumber, Status status) {
            this.ip = ip;
            this.userName = userName;
            this.date = date;
            this.event = event;
            this.taskNumber = taskNumber;
            this.status = status;
        }
    }
}