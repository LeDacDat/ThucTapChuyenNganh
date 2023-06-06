
package controllers;

import com.toedter.calendar.JCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author duato
 */
public class StatusBarController {
    protected TimerThread timerThread;
    
    private JLabel timeLable;
    private JLabel dateLable;
    private JLabel messageLable;
    
    private JCalendar jCalendar;
    private JPopupMenu calendarPopup;
    
    public StatusBarController(JLabel timeLable, JLabel dateLable, JLabel messageLable) {
        this.timeLable = timeLable;
        this.dateLable = dateLable;
        this.messageLable = messageLable;
        
        this.jCalendar = new JCalendar(new java.util.Locale("vi", "VN"));
        this.calendarPopup = new JPopupMenu();
        this.calendarPopup.add(jCalendar);
        
        setJCalendarPopup();
    }
    
    public void setStatusBarTimer() {
        timerThread = new TimerThread(this.dateLable, this.timeLable);
        timerThread.start();
    }
    
    private void setJCalendarPopup()
    {
        dateLable.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        dateLable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                calendarPopup.show(dateLable, e.getY(), e.getY());
            }

        });
    }
        
    public void exitProcedure() {
        timerThread.setRunning(false);
        System.exit(0);
    }
    
    
    
    private class TimerThread extends Thread {

        protected boolean isRunning;

        protected JLabel dateLabel;
        protected JLabel timeLabel;

        protected SimpleDateFormat dateFormat = 
                new SimpleDateFormat("dd-MM-yyyy");
        protected SimpleDateFormat timeFormat =
                new SimpleDateFormat("hh:mm:ss");

        public TimerThread(JLabel dateLabel, JLabel timeLabel) {
            this.dateLabel = dateLabel;
            this.timeLabel = timeLabel;
            this.isRunning = true;
        }

        @Override
        public void run() {
            while (isRunning) {
                SwingUtilities.invokeLater(() -> {
                    Calendar currentCalendar = Calendar.getInstance();
                    Date currentTime = currentCalendar.getTime();
                    dateLabel.setText(dateFormat.format(currentTime));
                    timeLabel.setText(timeFormat.format(currentTime));
                });

                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                }
            }
        }

        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }

    }
}
