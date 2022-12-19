<?php

namespace McrDigital\PhpFundamentals2\Bowling;

use PHPUnit\Framework\TestCase;
use McrDigital\PhpFundamentals2\Bowling\BowlingGame;
use function PHPUnit\Framework\assertEquals;

class BowlingTest extends TestCase
{
    public function testZeroScore(): void
    {
        
        $bowlingGame = new BowlingGame();
        $rolls = array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        
        $result = $bowlingGame->score($rolls);
        
        $this->assertEquals(0, $result);
    }

    public function testOnesScore(): void
    {

        $bowlingGame = new BowlingGame();
        $rolls = array(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);

        $result = $bowlingGame->score($rolls);

        $this->assertEquals(20, $result);
    }

    public function testSpareScore(): void
    {

        $bowlingGame = new BowlingGame();
        $rolls = array(5,5,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

        $result = $bowlingGame->score($rolls);

        $this->assertEquals(12, $result);
    }

    public function testStrikeScore(): void
    {

        $bowlingGame = new BowlingGame();
        $rolls = array(10,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

        $result = $bowlingGame->score($rolls);

        $this->assertEquals(14, $result);
    }

}