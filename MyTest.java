import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.*;

class MyMoneyTest {
	static KenoInfo betCard;

	@BeforeAll
	static void init() {
		betCard = new KenoInfo();
	}

	@Test
	void setting_spotLimit() {
		//setting limit
		betCard.setLimit(4);
		assertEquals(4,betCard.limit, "wrong value");
	}

	@Test
	void setting_limitOfDraws() {
		//limit draws
		betCard.setLimitDraw(4);
		assertEquals(4,betCard.limitDraws, "wrong value");
	}

	@Test
	void winning_NumberGen() {
		betCard.delAndGen();
		assertEquals(20,betCard.winningNumbers.size(), "wrong value");
	}

	@Test
	void matching10x10() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(10);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(100000,betCard.money, "wrong value");
	}

	@Test
	void matching10x9() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(10);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 1; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(4250,betCard.money, "wrong value");
	}

	@Test
	void matching10x8() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(10);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 2; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(450,betCard.money, "wrong value");
	}

	@Test
	void matching10x7() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(10);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 3; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(40,betCard.money, "wrong value");
	}


	@Test
	void matching10x6() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(10);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 4; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(15,betCard.money, "wrong value");
	}


	@Test
	void matching10x5() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(10);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 5; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(2,betCard.money, "wrong value");
	}

	@Test
	void matching10x0() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(10);
		betCard.winning();
		assertEquals(5,betCard.money, "wrong value");
	}

	@Test
	void matching8x8() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(8);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(10000,betCard.money, "wrong value");
	}

	@Test
	void matching8x7() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(8);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 1; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(750,betCard.money, "wrong value");
	}

	@Test
	void matching8x6() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(8);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 2; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(50,betCard.money, "wrong value");
	}

	@Test
	void matching8x5() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(8);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 3; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(12,betCard.money, "wrong value");
	}

	@Test
	void matching8x4() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(8);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 4; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(2,betCard.money, "wrong value");
	}

	@Test
	void matching4x4() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(4);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(75,betCard.money, "wrong value");
	}

	@Test
	void matching4x3() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(4);
		//matching all numbers
		for(int i = 0; i < betCard.limit-1; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(5,betCard.money, "wrong value");
	}

	@Test
	void matching4x2() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(4);
		//matching all numbers
		for(int i = 0; i < betCard.limit - 2; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(1,betCard.money, "wrong value");
	}

	@Test
	void matching1x1() {
		betCard.money = 0;
		betCard.numbersMatch.clear();
		betCard.setLimit(1);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();
		assertEquals(2,betCard.money, "wrong value");
	}

	@Test
	void adding() {
		betCard.money = 0;
		betCard.numbersMatch.clear();

		betCard.setLimit(1);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(4);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		assertEquals(77 ,betCard.money, "wrong value");
	}
	@Test
	void adding1() {
		betCard.money = 0;
		betCard.numbersMatch.clear();

		betCard.setLimit(1);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(1);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		assertEquals(4 ,betCard.money, "wrong value");
	}

	@Test
	void adding2() {
		betCard.money = 0;
		betCard.numbersMatch.clear();

		betCard.setLimit(1);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(4);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(8);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit - 1; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		assertEquals(827 ,betCard.money, "wrong value");
	}

	@Test
	void adding3() {
		betCard.money = 0;
		betCard.numbersMatch.clear();

		betCard.setLimit(1);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(4);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(8);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit - 1; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(1);
		betCard.numbersMatch.clear();
		betCard.winning();

		assertEquals(827 ,betCard.money, "wrong value");
	}

	@Test
	void adding4() {
		betCard.money = 0;
		betCard.numbersMatch.clear();

		betCard.setLimit(1);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(4);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(8);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit - 1; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(1);
		betCard.numbersMatch.clear();
		betCard.winning();

		betCard.setLimit(10);
		betCard.winning();

		assertEquals(832 ,betCard.money, "wrong value");
	}

	@Test
	void adding5() {
		betCard.money = 0;
		betCard.numbersMatch.clear();

		betCard.setLimit(1);
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(4);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(8);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit - 1; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		betCard.setLimit(1);
		betCard.numbersMatch.clear();
		betCard.winning();

		betCard.setLimit(10);
		betCard.winning();

		betCard.setLimit(10);
		betCard.numbersMatch.clear();
		//matching all numbers
		for(int i = 0; i < betCard.limit; i++){
			betCard.numbersMatch.add(i);
		}
		betCard.winning();

		assertEquals(100832 ,betCard.money, "wrong value");
	}


}
