<?php

namespace McrDigital\PhpFundamentals2\Bowling;

class BowlingGame
{
    public function score($rolls): int
    {
        $total = 0;
        $rollIndex = 0;
        for ($frame = 0; $frame < 10; $frame++ )   {
            $sumOfNextTwoRolls = $rolls[$rollIndex ] + $rolls[$rollIndex + 1];
            
            
            $spare = false;
            $strike = false;
            
            if ($sumOfNextTwoRolls == 10) {
                $spare = true;
            } elseif ($rolls[$rollIndex] == 10) {
                $strike = true;
                $total += $rolls[$rollIndex];
            }
            
            $total += $sumOfNextTwoRolls;
            
            
            if($spare) {
               $total += $rolls[$rollIndex + 2 ]; 
            } else if ($strike) {
             $total += $rolls[$rollIndex + 1 ] + $rolls[$rollIndex + 2];
            }
            $rollIndex += 2;
        }
        return $total;
    }
    
    
    
    public function __construct()
    {
    }
}