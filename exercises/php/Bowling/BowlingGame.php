<?php

namespace McrDigital\PhpFundamentals2\Bowling;

class BowlingGame
{
    public function score($rolls): int
    {
        $total = 0;
        $rollIndex = 0;
        for ($frame = 0; $frame < 10; $frame++ )   {
            $total += ($rolls[$rollIndex ] + $rolls[$rollIndex + 1] ) ;
            
            
            if($rolls[$rollIndex ] + $rolls[$rollIndex + 1] == 10) {
               $total += $rolls[$rollIndex + 2 ]; 
            }
            $rollIndex += 2;
        }
        return $total;
    }
    
    public function __construct()
    {
    }
}