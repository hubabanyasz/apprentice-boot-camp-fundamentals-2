<?php

namespace McrDigital\PhpFundamentals2\Billing;

use PHPUnit\Framework\TestCase;

class BillingTest extends TestCase 
{
    public function testBilling(): void
    {
        $privateSeller = new Customer();
        
        $monthlyBill = $privateSeller->bill();
        
        $this->assertEquals(0, $monthlyBill);
    }
}