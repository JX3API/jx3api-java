package jx3api.api.ws.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 新闻资讯
 * @author Grafie
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@WsActionData(actionCode = 2002)
public class WsDataAction2002 extends BaseWsData{
}
