import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

public final class MoneyUtil {

	private MoneyUtil() {
	}

	public static final int SCALE_ZERO = 0;
	public static final int SCALE_ONE = 1;
	public static final int SCALE_TWO = 2;

	/**
	 * 百
	 */
	public static final BigDecimal HUNDRED = new BigDecimal(100);

	/**
	 * 元转分
	 *
	 * @param yuan
	 *            元
	 * @return
	 */
	public static Integer convertYuanToCent(BigDecimal yuan) {
		if (yuan == null) {
			return NumberUtils.INTEGER_ZERO;
		}
		return yuan.multiply(HUNDRED).intValue();
	}

	/**
	 * 分转元，默认保留两位小数点，四舍五入方式舍入
	 *
	 * @param cent
	 *            分
	 * @return
	 */
	public static BigDecimal convertCentToYuan(int cent) {
		return new BigDecimal(cent).divide(HUNDRED, 2, RoundingMode.HALF_UP);
	}

	/**
	 * 分转元
	 *
	 * @param cent
	 *            分
	 * @param scale
	 *            精度
	 * @param roundingMode
	 *            舍入方式
	 * @return
	 */
	public static BigDecimal convertCentToYuan(int cent, int scale, RoundingMode roundingMode) {
		return new BigDecimal(cent).divide(HUNDRED, scale, roundingMode);
	}

	/**
	 * 精度处理
	 *
	 * @param m
	 *            金额
	 * @param scale
	 *            精度
	 * @return
	 */
	public static BigDecimal scaleHalfUp(BigDecimal m, int scale) {
		if (m == null) {
			return BigDecimal.ZERO.setScale(scale);
		} else {
			return m.setScale(scale, RoundingMode.HALF_UP);
		}
	}

	public static BigDecimal scaleFloor(BigDecimal m, int scale) {
		if (m == null) {
			return BigDecimal.ZERO.setScale(scale);
		} else {
			return m.setScale(scale, RoundingMode.FLOOR);
		}
	}

	public static BigDecimal scaleFloor(BigDecimal m) {
		if (m == null) {
			return BigDecimal.ZERO.setScale(MoneyUtil.SCALE_ONE);
		} else {
			return m.setScale(MoneyUtil.SCALE_ONE, RoundingMode.FLOOR);
		}
	}

	/**
	 * 是否大于0
	 *
	 * @param m
	 * @return
	 */
	public static boolean gtZero(BigDecimal m) {
		return m != null && m.compareTo(BigDecimal.ZERO) > 0;
	}

	/**
	 * 是否大于等于0
	 *
	 * @param m
	 * @return
	 */
	public static boolean geZero(BigDecimal m) {
		return m != null && m.compareTo(BigDecimal.ZERO) >= 0;
	}

	/**
	 * 是否等于0
	 *
	 * @param m
	 * @return
	 */
	public static boolean eqZero(BigDecimal m) {
		return m == null || m.compareTo(BigDecimal.ZERO) == 0;
	}

	/**
	 * 是小于0
	 *
	 * @param m
	 * @return
	 */
	public static boolean ltZero(BigDecimal m) {
		return m != null && m.compareTo(BigDecimal.ZERO) < 0;
	}

	/**
	 * 金额求和
	 *
	 * @param args
	 * @return
	 */
	public static BigDecimal addEachHalfUp(BigDecimal... args) {

		BigDecimal sum = BigDecimal.ZERO;
		if (ArrayUtils.isEmpty(args)) {
			return sum;
		}
		for (BigDecimal arg : args) {
			if (arg != null) {
				sum = sum.add(scaleHalfUp(arg, SCALE_TWO));
			}
		}
		return sum;
	}

	public static BigDecimal add(BigDecimal... args) {

		BigDecimal sum = BigDecimal.ZERO;
		if (ArrayUtils.isEmpty(args)) {
			return sum;
		}
		for (BigDecimal arg : args) {
			if (arg != null) {
				sum = sum.add(arg);
			}
		}
		return sum;
	}

}
