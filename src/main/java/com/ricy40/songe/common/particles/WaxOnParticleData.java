package com.ricy40.songe.common.particles;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Locale;

import com.ricy40.songe.core.init.ParticleInit;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WaxOnParticleData implements IParticleData {
    public static final WaxOnParticleData REDSTONE = new WaxOnParticleData(1.0F, 0.0F, 0.0F, 1.0F);
    public static final Codec<WaxOnParticleData> CODEC = RecordCodecBuilder.create((codecBuilder) -> {
        return codecBuilder.group(Codec.FLOAT.fieldOf("r").forGetter((group) -> {
            return group.r;
        }), Codec.FLOAT.fieldOf("g").forGetter((f1) -> {
            return f1.g;
        }), Codec.FLOAT.fieldOf("b").forGetter((f2) -> {
            return f2.b;
        }), Codec.FLOAT.fieldOf("scale").forGetter((f3) -> {
            return f3.scale;
        })).apply(codecBuilder, WaxOnParticleData::new);
    });
    public static final IParticleData.IDeserializer<WaxOnParticleData> DESERIALIZER = new IParticleData.IDeserializer<WaxOnParticleData>() {
        public WaxOnParticleData fromCommand(ParticleType<WaxOnParticleData> type, StringReader strReader) throws CommandSyntaxException {
            strReader.expect(' ');
            float f = (float)strReader.readDouble();
            strReader.expect(' ');
            float f1 = (float)strReader.readDouble();
            strReader.expect(' ');
            float f2 = (float)strReader.readDouble();
            strReader.expect(' ');
            float f3 = (float)strReader.readDouble();
            return new WaxOnParticleData(f, f1, f2, f3);
        }

        public WaxOnParticleData fromNetwork(ParticleType<WaxOnParticleData> type, PacketBuffer buffer) {
            return new WaxOnParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
        }
    };
    private final float r;
    private final float g;
    private final float b;
    private final float scale;

    public WaxOnParticleData(float f1, float f2, float f3, float f4) {
        this.r = f1;
        this.g = f2;
        this.b = f3;
        this.scale = MathHelper.clamp(f4, 0.01F, 4.0F);
    }

    public void writeToNetwork(PacketBuffer buffer) {
        buffer.writeFloat(this.r);
        buffer.writeFloat(this.g);
        buffer.writeFloat(this.b);
        buffer.writeFloat(this.scale);
    }

    public String writeToString() {
        return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.r, this.g, this.b, this.scale);
    }

    public ParticleType<WaxOnParticleData> getType() {
        return ParticleInit.WAX_ON_PARTICLE.get();
    }

    @OnlyIn(Dist.CLIENT)
    public float getR() {
        return this.r;
    }

    @OnlyIn(Dist.CLIENT)
    public float getG() {
        return this.g;
    }

    @OnlyIn(Dist.CLIENT)
    public float getB() {
        return this.b;
    }

    @OnlyIn(Dist.CLIENT)
    public float getScale() {
        return this.scale;
    }
}
