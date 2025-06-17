package transport;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation <T extends Transport> {
    private final Queue<T> queue = new LinkedList<>();

    public void addCar (T transport) {
        if (!(transport instanceof Bus)){
            queue.offer(transport);
            System.out.println(transport.getBrand()+ " " + transport.getModel() + " транспорт добавлен в очередь");
        } else {
            System.out.println("Автобус не обслуживается");
        }

    }
    public void technicalInspection() {
        Transport transport =  queue.poll();
        if (transport != null) {
            System.out.println("Техосмотр: " + transport.getBrand() + " " + transport.getModel());
            technicalInspection();
        } else {
            System.out.println("Очередь пуста");
        }
    }
    public int queueSize () {
        return queue.size();
    }
}