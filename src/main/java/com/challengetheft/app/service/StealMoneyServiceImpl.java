package com.challengetheft.app.service;

import org.springframework.stereotype.Service;

/**
 * Service to computes the maximum sum in an array of non-adjacent numbers
 */
@Service
public class StealMoneyServiceImpl implements StealMoneyService {

	@Override
	public int stealMoney(int[] houseMoney) {
		int inclusive = 0;
        int exclusive = 0;

        for (int num : houseMoney) {
            int temp = inclusive;
            inclusive = Math.max(inclusive, exclusive + num);
            exclusive = temp;
        }
        
        return Math.max(inclusive, exclusive);
	}

}
