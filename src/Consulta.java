import java.util.ArrayList;
import java.util.List;

public record Consulta(String result,
                       String time_last_update_utc,
                       String base_code,
                       String target_code,
                       double conversion_rate,
                       double conversion_result){
}
