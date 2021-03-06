package employee.notifications;

import java.util.List;

/**
 * Holds all the information from "notifications.yaml" configuration file.
 * Provides an access to specifics {@link NotificationWrapper} when a region
 * changes and needs to notify this change.
 *
 * Created by luisburgos on 6/11/15.
 */
public class PushNotificationManager {

    private List<NotificationWrapper> notifications;

    public PushNotificationManager (){}

    public void setNotifications(List<NotificationWrapper> notifications) {
        this.notifications = notifications;
    }

    public List<NotificationWrapper> getNotifications() {
        return notifications;
    }

    public NotificationWrapper getByName(String name){
        NotificationWrapper wrapperByName = null;
        for(NotificationWrapper wrapper : notifications){
            if(wrapper.getRegionName().equalsIgnoreCase(name)){
                wrapperByName = wrapper;
            }
        }
        return wrapperByName;
    }

}
