package com.ricy40.songe.common.particles;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class WaxOnParticle extends SpriteTexturedParticle {

    protected WaxOnParticle(ClientWorld worldIn, double xPos, double yPos, double zPos, double xSpeed, double ySpeed, double zSpeed) {
        super(worldIn, xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);

        float f = this.random.nextFloat() * 1.0f;
        this.rCol = f;
        this.gCol = f;
        this.bCol = f;

        this.setSize(0.02f, 0.02f);
        this.quadSize *= 0.75F;
        this.xd *= (double)0.02f;
        this.yd *= (double)0.02f;
        this.zd *= (double)0.02f;
        this.lifetime = (worldIn.random.nextInt(30) + 10);
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.lifetime-- <= 0) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
            this.xd *= 1.0D;
            this.yd *= 1.0D;
            this.zd *= 1.0D;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {

        private final IAnimatedSprite spriteSet;
        public Factory(IAnimatedSprite sprite) {
        this.spriteSet = sprite;
    }

        @Nullable
        @Override
        public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double xPos, double yPos, double zPos, double xSpeed, double ySpeed, double zSpeed) {
            WaxOnParticle waxOnParticle = new WaxOnParticle(worldIn, xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
            waxOnParticle.setColor(1.0f, 1.0f, 1.0f);
            waxOnParticle.pickSprite(this.spriteSet);
            return waxOnParticle;
        }
    }
}
